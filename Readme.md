# Tarea: arquitectura MVC

EXAMEN FINAL 3º TRIMESTRE
Arquitectura MVC

`Aqui estan el diagrama de clases y el diagrama de secuencia del programa.`

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
```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    Controller->>Model: Puedes crear un coche?
    activate Model
    Model-->>Controller: Creado!
    deactivate Model
    Controller->>Model: Cambia la velocidad del coche
    activate Model
    Model-->>Controller: Velocidad cambiada!
    deactivate Model
    Controller->>+View: Muestra la velocidad, porfa
    activate View
    View->>-View: Mostrando velocidad
    View-->>Controller: Listo!
    deactivate View
```