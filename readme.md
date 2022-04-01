# Getting Started

./gradlew jibDockerBuild

docker run --rm royalespn/springboottaskscheduler:latest

docker tag royalespn/springboottaskscheduler:001 royalespn/springboot-prometheus:latest

docker push royalespn/springboottaskscheduler:latest

docker run --rm -e MANAGEMENT_METRICS_EXPORT_PROMETHEUS_PUSHGATEWAY_BASE-URL='host.docker.internal:9091' royalespn/springboottaskscheduler:001

--
DATASOURCE_URL='jdbc:mariadb://host.docker.internal:3306/prometheusdeepdrive'