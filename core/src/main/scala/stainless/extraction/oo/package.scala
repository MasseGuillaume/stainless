/* Copyright 2009-2016 EPFL, Lausanne */

package stainless
package extraction

package object oo {

  object trees extends Trees with ClassSymbols {
    case class Symbols(
      functions: Map[Identifier, FunDef],
      adts: Map[Identifier, ADTDefinition],
      classes: Map[Identifier, ClassDef]
    ) extends ClassSymbols

    object printer extends Printer { val trees: oo.trees.type = oo.trees }
  }

  object methods extends MethodLifting {
    val s: trees.type = trees
    val t: trees.type = trees
    val name = "MethodLifting"
  }

  object adts extends AdtSpecialization {
    val s: trees.type = trees
    val t: trees.type = trees
    val name = "AdtSpecialization"
  }

  object encoding extends TypeEncoding {
    val s: trees.type = trees
    val t: holes.trees.type = holes.trees
    val name = "TypeEncoding"
  }

  val extractor = methods andThen adts andThen encoding
}
