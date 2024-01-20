package frc.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.RegexFileFilter;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryUtil;

//Concurrent Trajectory Loader with cache
public class TrajectoryLoader {
    
    private static TrajectoryLoader m_instance;

    private Map<String, Trajectory> trajectoryCache;
    private ExecutorService executor 
      = Executors.newCachedThreadPool();

    public static TrajectoryLoader getInstance() {
        if(m_instance == null) {
            m_instance = new TrajectoryLoader();
        }
        return m_instance;
    }

    private TrajectoryLoader() {
        trajectoryCache = new HashMap<String, Trajectory>();
        loadTrajectories();
    }

    //Loads all paths
    private void loadTrajectories() {
        // Get roborio path directory
        Path pathDirectory = Filesystem.getDeployDirectory().toPath().resolve("paths");
        // Walk through all paths and collect files that end in ".wpilib.json". 
        Collection<File> files = FileUtils.listFiles(pathDirectory.toFile(),
                            new RegexFileFilter("^.*(.wpilib.json)$"),
                            DirectoryFileFilter.DIRECTORY);

        //Collection of options and corresponding futures
        List<Callable<Tuple<String,Trajectory>>> trajectoryCallables = new ArrayList<Callable<Tuple<String,Trajectory>>>();

        //Ties trajectories into list
            files.iterator().forEachRemaining(file -> {
                if(System.getProperty("os.name").trim().equals("Windows 10".trim())){
                    String key = file.getAbsolutePath().split("paths")[1].substring(1);
                    trajectoryCallables.add(loadTrajectory(key,file));
                }else{
                    String key = file.getAbsolutePath().split("paths/")[1];
                    trajectoryCallables.add(loadTrajectory(key,file));
                }
            });
        try {
            //Execute all loading callables
            List<Future<Tuple<String, Trajectory>>> trajectoryFutures = executor.invokeAll(trajectoryCallables);
            Iterator<Future<Tuple<String,Trajectory>>> futureIterator = trajectoryFutures.iterator();
            while(futureIterator.hasNext()){
                //Get current Future for Tuple
                Future<Tuple<String, Trajectory>> trajectoryPairFuture = futureIterator.next();
                //Unwrap Future
                Tuple<String,Trajectory> trajectoryPair = trajectoryPairFuture.get();
                trajectoryCache.put(trajectoryPair.getLeft(), trajectoryPair.getRight());
            }
            
        } catch (InterruptedException e) {
            DriverStation.reportError("Interrupted during loading. ", e.getStackTrace());
        } catch (ExecutionException e) {
            DriverStation.reportError("Execution interrupted during loading", e.getStackTrace());
        }
        
    }

    public Callable<Tuple<String,Trajectory>> loadTrajectory(String key,File trajectoryJSON) {
        return new Callable<Tuple<String,Trajectory>>() {
            public Tuple<String,Trajectory> call() throws IOException {
                Path trajectoryPath = Path.of(trajectoryJSON.getAbsolutePath());
                return new Tuple<String, Trajectory> (key,TrajectoryUtil.fromPathweaverJson(trajectoryPath));
            }
            
        };
    }

    public void reloadPaths() {
        trajectoryCache.clear();
        loadTrajectories();
    }

    public Set<String> getAllPaths() {
        return trajectoryCache.keySet();
    }

}
