package com.xonal.Fp

sealed trait List[+A]
case object Nil extends List[Nothing]
case class Cons[A](head: A, tail:List[A]) extends List[A]

object List{
  def sum(xs: List[Int]): Int = xs match {
    case Nil => 0
    case Cons(h,t) => h + sum(t)
  }
  def product(xs: List[Int]): Int = xs match {
    case Nil => 1
    case Cons(0,_) => 0
    case Cons(h,t) => h * product(t)
  }
  def tail(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case Cons(_,t) => t
  }
  def setHead(xs: List[Int], x: Int): List[Int] = xs match {
    case Nil => Nil
    case Cons(_,t) => Cons(x, t)
  }
  def drop(l: List[Int], n: Int): List[Int] = {
    if(n <= 0) l
    else l match {
      case Nil => Nil
	  case Cons(_,t) => drop(t, n-1)
    }
  }
  def dropWhile[A](l:List[A], f: A => Boolean): List[A] = l match {
    case Cons(h,t) if f(h) => dropWhile(t, f)
    case _ => l
  }
  def foldRight[A,B](l: List[A], z:B)(f: (A, B) => B): B = l match {
     case Nil => z
     case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }
  @annotation.tailrec
  def foldLeft[A,B](l:List[A], acc: B, f:(B,A) => B): B = l match {
    case Nil => acc
    case Cons(h,t) => foldLeft(t,f(acc, h), f)
  }

  def apply[A](xs:A*): List[A] = {
    if(xs.isEmpty) Nil
    else Cons(xs.head, apply(xs.tail:_*))
  }
}
