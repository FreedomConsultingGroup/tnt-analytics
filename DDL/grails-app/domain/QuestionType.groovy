/**
 * The QuestionType entity.
 *
 * @author  Scott Beall  FCG
 *
 *
 */
class QuestionType {
    static mapping = {
         table 'question_type'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id column:'id'
    }
    java.math.BigDecimal id
    String qustionType

    static constraints = {
        id()
        qustionType(size: 0..25)
    }
    String toString() {
        return "${id}" 
    }
}
