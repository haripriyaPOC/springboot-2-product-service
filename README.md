# product-service

Sample product API with in-memory demo data

## Requirements
- Java 17
- Maven 3.9+ (optional if using Docker build)
- Docker (for container build)
- Kubernetes and kubectl (for Kubernetes deployment)

## Run locally
```bash
mvn spring-boot:run
```

Test the API:
```bash
curl http://localhost:8080/api/products
curl http://localhost:8080/actuator/health
```

## Build a JAR
```bash
mvn clean package
java -jar target/product-service-0.0.1-SNAPSHOT.jar
```

## Build and run with Docker
```bash
docker build -t product-service:1.0.0 .
docker run --rm -p 8080:8080 product-service:1.0.0
```

Then test `http://localhost:8080/api/products`.

## Deploy to Kubernetes
1. Update the image in `k8s/deployment.yaml` to the image you pushed to your registry.
2. Push the image to your registry, for example:
   ```bash
   docker tag product-service:1.0.0 YOUR_REGISTRY/product-service:1.0.0
   docker push YOUR_REGISTRY/product-service:1.0.0
   ```
3. Apply the manifests:
   ```bash
   kubectl apply -f k8s/
   kubectl rollout status deployment/product-service
   kubectl get pods,svc -l app=product-service
   ```
4. Test from inside the cluster or port-forward:
   ```bash
   kubectl port-forward svc/product-service 8080:80
   curl http://localhost:8080/api/products
   ```

## Health checks
- `/actuator/health`
- `/actuator/health/readiness`
- `/actuator/health/liveness`

These are demo applications with in-memory/static data only; no database is required.
