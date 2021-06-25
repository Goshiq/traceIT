# traceIT
### Still beta

It is a web-tool to make a scene for 3D-engine: https://github.com/ifanzilka/miniRT

## Starting
- You can use docker to start the project
```C
git clone git@github.com:Goshiq/traceIT.git && cd traceIT/Dockerize
```
- Start the script
```C
/bin/sh start_spp.sh
```
- Open the page:
```html
http://localhost:8080
```

## Using the tool
Steps to create a scene:
- 1 Press "Новая сцена"(New scene) to create new scene
- 1.1 Press "Открыть сцену"(Load scene) to edit existed one
- 2 Choose the object you want to add:
- 2.1 "Фигура"(Figure)
- 2.1.1 "Сфера"(Sphere)
- 2.1.2 "Плоскость"(Plane)
- 2.2 "Свет"(Light)
- 2.3 "Камера"(Camera)

ER-Diagram:

![Class Diagram](https://github.com/Goshiq/traceIT/blob/main/ER-Diagram.png)
