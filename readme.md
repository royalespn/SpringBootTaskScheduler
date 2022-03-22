# Getting Started

./gradlew jibDockerBuild

docker run --rm royalespn/springboottaskscheduler:001

docker tag royalespn/springboottaskscheduler:001 royalespn/springboot-prometheus:latest

docker push royalespn/springboottaskscheduler:001:latest

docker run --rm -e MANAGEMENT_METRICS_EXPORT_PROMETHEUS_PUSHGATEWAY_BASE-URL='host.docker.internal:9091' royalespn/springboottaskscheduler:001

