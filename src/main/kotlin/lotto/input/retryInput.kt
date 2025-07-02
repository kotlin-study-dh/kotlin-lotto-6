package lotto.input

inline fun <T> retryInput(
    crossinline block: () -> T
): T {
    while (true) {
        try {
            return block()
        } catch (e: Exception) {
            println("[ERROR]${e.message}")
        }
    }
}
