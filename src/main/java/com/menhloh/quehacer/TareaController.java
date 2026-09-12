package com.menhloh.quehacer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    // GET /tareas - Obtener todas las tareas
    @GetMapping
    public List<Tarea> obtenerTodas() {
        return tareaRepository.findAll();
    }

    // POST /tareas - Crear una nueva tarea
    @PostMapping
    public Tarea crearTarea(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    // PUT /tareas/{id} - Actualizar una tarea existente
    @PutMapping("/{id}")
    public Tarea actualizarTarea(@PathVariable Long id, @RequestBody Tarea tareaActualizada) {
        Tarea tarea = tareaRepository.findById(id).orElseThrow();
        tarea.setTitulo(tareaActualizada.getTitulo());
        tarea.setCompletada(tareaActualizada.isCompletada());
        return tareaRepository.save(tarea);
    }

    // DELETE /tareas/{id} - Borrar una tarea
    @DeleteMapping("/{id}")
    public void borrarTarea(@PathVariable Long id) {
        tareaRepository.deleteById(id);
    }
}