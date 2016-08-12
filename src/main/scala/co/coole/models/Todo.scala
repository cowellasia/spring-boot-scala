package co.coole.models

import java.net.URI

import scala.beans.BeanProperty

class Todo {

  @BeanProperty
  var url: URI = _

  var requestURI: String = _

  @BeanProperty
  var id: Long = _

  @BeanProperty
  var title: String = _

  def titleOption = Option(title)

  @BeanProperty
  var completed: Boolean = _

  def completedOption = Option(completed)

  @BeanProperty
  var order: Integer = _

  def orderOption = Option(order)

}