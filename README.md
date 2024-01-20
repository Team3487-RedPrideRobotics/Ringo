# Robot-Base
 A base project for FRC Control Systems
** TODO ** Build Dynamic Constants system so that you don't have to change Constants.java everytime you want new stuff.
## Goals
* Reduce deploy time by using smart robot programs. Features such as automatic path loading and JSON based constant settings.

## Constants Reference
### Main Constants Object
| Option 	| Type   	| Example       	|
|--------	|--------	|---------------	|
| Drive  	| Object 	| `Drive {...}` 	|
| Auto   	| Object 	| `Auto {...}`  	|

### Drive Constants Object

## TODO
* create dynamic constants system that
    * will create constants classes for each subsystem based on a yaml file
    * allow for defining constants of types that can't be defined in a yaml file
    * allow for defining other constants based on a json file
