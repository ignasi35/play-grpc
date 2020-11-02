/*
 * Copyright (C) Lightbend Inc. <https://www.lightbend.com>
 */
package example.myapp.helloworld.grpc.helloworld

import scala.concurrent.Future

import akka.actor.ActorSystem
import javax.inject.Inject
import javax.inject.Singleton

/** User implementation, with support for dependency injection etc */
@Singleton
class GreeterServiceImpl @Inject() (implicit actorSystem: ActorSystem)
    extends AbstractGreeterServiceRouter(actorSystem) {

  override def sayHello(in: HelloRequest): Future[HelloReply] = {
    actorSystem.log.error("Saying hello!")
    Future.successful(HelloReply(s"Hello, ${in.name}!"))
  }

}
// #service-impl
