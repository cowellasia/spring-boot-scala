package co.coole.controllers

import java.lang.Long
import javax.servlet.http.HttpServletRequest

import co.coole.models.Todo
import co.coole.services.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation._

import scala.collection.JavaConversions._

@RestController
@CrossOrigin
@RequestMapping(Array("/todos"))
class TodoController @Autowired()(private val todoService: TodoService) {

  @RequestMapping(method = Array(RequestMethod.GET))
  def getAll(): java.util.List[Todo] = {
    todoService getAll
  }

  @RequestMapping(value = Array("/{id}"), method = Array(RequestMethod.GET))
  def getByID(@PathVariable("id") id: Long): Todo = {
    todoService.get(id).getOrElse(null)
  }

  @RequestMapping(method = Array(RequestMethod.POST))
  def create(@RequestBody todo: Todo, request: HttpServletRequest): Todo = {
    todo.requestURI = request.getRequestURL().toString
    todoService.create(todo)
  }

  @RequestMapping(value = Array("/{id}"), method = Array(RequestMethod.PATCH))
  def edit(@PathVariable("id") id: String, @RequestBody todoUpdates: Todo, request: HttpServletRequest): Todo = {
    todoUpdates.id = id.toLong
    todoService.edit(todoUpdates)
  }

  @RequestMapping(value = Array("/{id}"), method = Array(RequestMethod.DELETE))
  def deleteByID(@PathVariable("id") id: Long) = {
    todoService.delete(id)
  }

  @RequestMapping(method = Array(RequestMethod.DELETE))
  def deleteAll() {
    todoService deleteAll
  }

}
