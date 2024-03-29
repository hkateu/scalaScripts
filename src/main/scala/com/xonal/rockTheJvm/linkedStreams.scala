package con.xonal.RockTheJvm

object linkedStreams extends App{
  abstract class MyStream[+A]{
    def isEmpty: Boolean
    def head: A
    def tail: MyStream[A]

    def #::[B >: A](element: B): MyStream[B]
    def ++[B >: A](anotherStream: MyStream[B]): MyStream[B]

    def foreach(f: A => Unit): Unit
    def map[B](f: A => B): MyStream[B]
    def flatMap[B](f: A => MyStream[B]): MyStream[B]
    def filter(predicate: A => Boolean): MyStream[A]


object MyStream{
  //def apply[+A](values: A*): MyStream[A] = {

  //}
}
/*object MySet{
    def apply[A](values: A*): MySet[A] = {
      @tailrec
      def buildSet(valSeq: Seq[A], acc: MySet[A]): MySet[A] =
            if(valSeq.isEmpty) acc
            else buildSet(valSeq.tail, acc + valSeq.head)
      buildSet(values.toSeq, new EmptySet[A])
    }
  } */
}

}
