class ContaBancaria(
    val agencia: String,
    val conta: String,
    val senha: String
) {
    var usuarioAutenticado: Boolean = false
    var saldo: Double = 0.0

    init {

        usuarioAutenticado = true
    }

    fun recuperarSaldo(): Double {
        return if (usuarioAutenticado) saldo else 0.0
    }

    fun depositar(valor: Double) {
        saldo += valor
    }

    fun sacar(valor: Double) {
        saldo -= valor
    }

    fun extrato(dias: Int) {
        println("Extrato dos últimos $dias dias")
    }

    fun extrato(dataInicial: String, dataFinal: String) {
        println("Extrato intervalo $dataInicial e $dataFinal")
    }
}

fun main() {
    val minhaConta = ContaBancaria("1234", "56789-0", "senha123")

    println("Saldo inicial: R$ ${minhaConta.recuperarSaldo()}")

    minhaConta.depositar(200.0)
    minhaConta.sacar(500.0)

    println("Saldo após operações: R$ ${minhaConta.recuperarSaldo()}")

    minhaConta.extrato(5)
    minhaConta.extrato("10/05/2022", "10/06/2022")
}
