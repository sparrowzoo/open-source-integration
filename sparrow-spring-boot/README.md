配置 key
---
com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager

com.netflix.hystrix.HystrixCommandProperties

prometheus
---
http://localhost:9200/actuator/prometheus

metrics
---
http://localhost:9200/actuator/metrics

health
---
http://localhost:9200/actuator/health

parameters query
---
http://localhost:9200/actuator/metrics/resilience4j.circuitbreaker.buffered.calls?tag=kind:failed