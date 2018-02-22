# AED — Entrega Individual 6: Heap Order Checker
**Autor:** Luis Bravo  
**Curso:** 2017–2018 — Algoritmos y Estructuras de Datos (UPM)

Proyecto **Maven** organizado para la práctica de verificación de la propiedad de orden de montículo (*Heap Order Property*).

## Estructura
```
src/
  main/java/aed/heaps/
    HeapOrderChecker.java
  test/java/aed/heaps/
    TesterInd6.java
    BuildSmokeTest.java
docs/guia.pdf
libs/net-datastructures-5.0.jar   # añadir manualmente
```

## Uso
```bash
# 1) Copia la librería net-datastructures-5.0.jar en la carpeta libs/
# 2) Compila y ejecuta los tests
mvn -q -DskipTests=false test
```

### Descripción del ejercicio
Implementar el método estático:
```java
static <E extends Comparable<E>> boolean satisfiesHeapOrderProperty(BinaryTree<E> tree)
```
que devuelve `true` si el árbol cumple la propiedad de orden de montículo (cada nodo tiene un valor mayor o igual que el de su padre) y `false` en caso contrario.

El árbol no debe modificarse y el método debe funcionar para cualquier tipo `E` comparable.

**Ejemplo de uso:**
```
         10
       /          14     18
     /      20   16
```
✅ `satisfiesHeapOrderProperty(tree)` → `true`

Consulta *docs/guia.pdf* para más detalles.

— *Luis Bravo*