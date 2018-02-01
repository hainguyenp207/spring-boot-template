# Spring Boot Boilerplate
## Technology
1. Spring Boot v1.5.9
2. Spring Security
3. JPA - Hikari 
4. Thymeleaf Template
## Struct
1. Project
```
| -- config
| -- build
| -- logs
| -- target
| -- src
      | - config
      | - constant
      | - controller
      | - api 
      | - dao 
           | - entity
           | - repository
      
      | - security
      | - service
      | - utils
```
### Description
1. config: Contains code config DB, Bean, Load Config file
2. constant: Some constants: Paramters, Key
3. logs: path logs file 
4. target: contains jar after built
5. build : contains bash file to run project on UAT or Pro env. Write `worker` and `control.sh`
6. src: Of course: It contains your source codes : =.=

# How to run
## On local
1. Import project to your favorite idea like IntelJ, Eclipse, NetBean ....
2. Wait to import dependencies
3. Edit config file like DB in ./config
4. Click play button on toolbar || Run cmd `spring-boot:run`
5. Enjoy

## UAT | Pro
I think it's good way to deloy and run a project on server
1. Edit config in ./config folder
2. Edit `worker` and `control.sh` files in `build` folder
- `worker` : Edit file name `.jar` 
- `control.sh` : Pass your params into `params` like path logs, path configs, port v,v..
3. Install jar file: `mvn clean install`
4. Copy file jar and build, config to server
5. Run cmd `control.sh start/stop/restart` | Pick one command : start/stop/restart

Sometime you have been have bugs.


