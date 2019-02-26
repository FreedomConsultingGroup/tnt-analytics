/**
 * The QuestionType entity.
 *
 * @author    
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

    static constraints = {
        qustionType(size: 0..25)
        idQuestions()
    }
    String toString() {
        return "${id}" 
    }
}
