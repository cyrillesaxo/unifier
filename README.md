# By Cyrille V Eloundou ( Java solution Architect)

Unifier project


To run this project use:

1) start git server ( we are using gitlib. you can also use github)
2) run the config-server
3) run the Eureka-server
4) run the hystrix-server
5) run the zipking-server
6) start the mongodb server ( mongod)
7) start the application  (from eclipse by runing spring-boot or using maven " mvn spring-boot:run")




==============   links  ==============================
Then navigate to [http://localhost:8181/docs/index.html](http://localhost:8181/docs/index.html) to 
see the Swagger documentation.

The health check url: http://localhost:8181/health
hystrix:http://localhost:9023/
 hystrix input test: http://localhost:9023/hystrix.stream
Eureka (service registry and discovery): http://localhost:8761/
zipking: http://localhost:9411/

orchestration : http://localhost:8086/1/33.969601/-84.100033/integration

http://localhost:4040/1/33.969601/-84.100033/integration


 -- actuator

http://localhost:8181/health
http://localhost:8181/metrics
http://localhost:8181/beans
http://localhost:8181/configprops
http://localhost:8181/mappings
http://localhost:8181/env
http://location.apps.px-01.cf.t-mobile.com

 -- zuul
 
 http://localhost:5051/equipment/api/ping

 
 http://localhost:5051/mappings
 http://localhost:5051/location/Location/api-doc
 http://localhost:5051/location/health
 http://localhost:5051/env  ( see all the properties)
 http://localhost:5051/env/restrictedUrls
POST  http://localhost:5051/refresh  ["restrictedUrls"] ( for re-loading the boot strap context and refreshing the)
 http://localhost:5051/browser/index.html#http://localhost:8081/api/ping
 http://localhost:5051/hystrix.stream
 