enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nameUser: String, val registrationUser: String) {
    override fun toString(): String {
        return "$nameUser (matrícula $registrationUser)"
    }
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60) {
    override fun toString(): String {
        return "$nome (Duração: $duracao)"
    }
}

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario)
    }
    
    override fun toString(): String {
        return """
        Formação: $nome
        Conteúdo educacional: $conteudos
        Duração do conteúdo: 
        Nível: $nivel
        Alunos inscritos na Formação: $inscritos
        """.trimIndent()
    	}
        
    }


fun generateMatricula(): String {
    return (1000..10000).random().toString()
}

fun main() {
    val ronan = Usuario("Ronan", generateMatricula())
    val pedro = Usuario("Pedro", generateMatricula())
    val bruna = Usuario("Bruna", generateMatricula())
    val jonas = Usuario("Jonas", generateMatricula())
    
    val conteudoEducacionalJava = ConteudoEducacional("Java", 150)
    val conteudoEducacionalKotlin = ConteudoEducacional("Kotlin", 120)
        
    val formacaoJava =
            Formacao(
                	"Java Developer"
                     , listOf(conteudoEducacionalJava)
                     , Nivel.INTERMEDIARIO
            )
    val formacaoKotlin =
            Formacao(
                "Formação Kotlin Developer"
                , listOf(conteudoEducacionalKotlin)
                , Nivel.BASICO
            )
 
    formacaoJava.matricular(pedro, jonas)
    formacaoKotlin.matricular(ronan, bruna)
   
    println(formacaoJava)
    println("\n**********************\n")
    println(formacaoKotlin)
    println("\n**********************\n")
}