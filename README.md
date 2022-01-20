# kubernetes-workshop

<div align=center>
  <img src="https://www.linuxadictos.com/wp-content/uploads/kubernetes-logo.jpg.webp" width="250" height="150" title="Kubernetes"/>
  <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Docker_%28container_engine%29_logo.svg/1280px-Docker_%28container_engine%29_logo.svg.png" width="350" height="150" title="Docker"/>
</div>

## Prerequisites

* Java (JDK) 11 or 17 - https://adoptium.net/
* Docker - https://docs.docker.com/get-docker/
* Minikube - https://minikube.sigs.k8s.io/docs/start/

## Execution

Launch Minikube:
```
minikube start
```

Ensure your current terminal session is configured to use the Minikube Docker daemon by running the below command:
```
eval $(minikube docker-env)
```

### First service: hero-monolith

In `hero-monolith` folder launch:
```
mvn package; docker build -f src/main/docker/Dockerfile.jvm -t workshop/hero-monolith .; kubectl delete deployment hero-monolith; kubectl apply -f kubernetes/
```

### Second service: villain-monolith

In `villain-monolith` folder launch:
```
mvn package; docker build -f src/main/docker/Dockerfile.jvm -t workshop/villain-monolith .; kubectl delete deployment villain-monolith; kubectl apply -f kubernetes/
```

### Main service: supes-monolith

In `supes-monolith` folder launch:
```
mvn package; docker build -f src/main/docker/Dockerfile.jvm -t workshop/supes-monolith .; kubectl delete deployment supes-monolith; kubectl apply -f kubernetes/
```

To get the address of the service `supes-monolith`, you can use the below command, which will return the address:
```
minikube service supes-monolith --url
```

## More information
For more information about this workshop check this useful repo of Clement Escoffier:
https://github.com/cescoffier/kubernetes-workshop

