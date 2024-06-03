# Tarea: arquitectura MVC

Tarea para implementar arquitectura MVC

Utiliza objetos coches, modifica la velocidad y la muestra

---

### Diagrama de clases:

```mermaid
classDiagram
    class Coche {
        String: matricula
        String: modelo
        Integer: velocidad
    }
    class Observer {
        +update(Coche)
    }
    class Model {
        ArrayList~Coche~: parking
        ArrayList~Observer~: observers
        +crearCoche(String, String): Coche
        +getCoche(String): Coche
        +cambiarVelocidad(String, Integer, Model): Integer
        +getVelocidad(String): Integer
        +removeObserver(Observer)
        +notifyObservers(Coche)
        +subirVelocidad(String, Integer, Model): Integer
        +bajarVelocidad(String, Integer, Model): Integer
    }
    class Controller{
        +main()
    }
    class View {
        +muestraVelocidad(String, Integer)
    }
    Controller "1" *-- "1" Model : association
    Controller "1" *-- "1" View : association
    Model "1" *-- "1..n" Coche : association
    Model "1" *-- "1..n" Observer : association
```

---

### Diagrama de Secuencia

Ejemplo básico del procedimiento, sin utilizar los nombres de los métodos


```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Creado!
    deactivate Model
    Controller->>+View: Muestra la velocidad, porfa
    activate View
    View->>-View: Mostrando velocidad
    View-->>Controller: Listo!
    deactivate View
```

El mismo diagrama con los nombres de los métodos

```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: crearCoche("Mercedes", "BXK 1234")
    activate Model
    Model-->>Controller: Coche
    deactivate Model
    Controller->>+View: muestraVelocidad("BXK 1234", velocidad)
    activate View
    View->>-View: System.out.println()
    View-->>Controller: boolean
    deactivate View
```