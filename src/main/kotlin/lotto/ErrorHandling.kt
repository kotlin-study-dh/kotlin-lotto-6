package lotto

class ErrorHandling {

    companion object {
        fun <T> retry(block: () -> T, errorHandler: (Exception) -> Unit): T {
            while (true) {
                try {
                    return block()
                } catch (e: Exception) {
                    errorHandler.invoke(e)
                }
            }
        }
    }
}