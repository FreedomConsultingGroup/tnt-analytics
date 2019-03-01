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
         idQuestions column:'id'
    }
    String qustionType
    java.math.BigDecimal questionId

    static constraints = {
        qustionType(size: 0..25)
        questionId()
        idQuestions()
    }
    String toString() {
        return "${id}" 
    }
}
