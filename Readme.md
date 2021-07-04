# traceIT
### Still beta

It is a web-tool to make a scene for 3D-engine: https://github.com/Goshiq/RT

## Starting
- You can use docker to start the project
```C
git clone https://github.com/Goshiq/traceIT.git && cd traceIT/Dockerize
```
- Start the script
```C
/bin/sh start_spp.sh
```
- Open the page:
http://localhost:8080

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
- 3 You can print the scene in the miniRT project format by pressing "Получить сцену"(Get the scene) 

ER-Diagram:
![Class Diagram](https://github.com/Goshiq/traceIT/blob/main/ER-Diagram.png)
