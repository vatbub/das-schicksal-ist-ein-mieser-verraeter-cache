import java.io.File
import java.io.FileReader
import java.io.PrintStream

val inputFile = File("src/characters.tex")
val outputFile = File("src/characters.ahk")

println("Input file: ${inputFile.absolutePath}")
println("Output file: ${outputFile.absolutePath}")

val lines = FileReader(inputFile).buffered().use { it.readLines() }
val processedTerms = lines
    .map { it.removePrefix("\\character") }
    .map { it.replace("\\[.*]".toRegex(), "") }
    .map { it.removePrefix("{") }
    .map { it.removeSuffix("}") }
    .map { it.split("}{") }
    .map { it[0] }

val processedSingularLines = processedTerms
    .map { "::$it::\\gls{{}$it{}}" }

val processedPluralLines = processedTerms
    .map { "::${it}s::\\glspl{{}$it{}}" }

PrintStream(outputFile).use { outputWriter ->
    outputWriter.println("#NoEnv")
    outputWriter.println("SendMode Input")
    outputWriter.println("#SingleInstance, force")

    processedSingularLines.forEach { line ->
        outputWriter.println(line)
    }

    processedPluralLines.forEach { line ->
        outputWriter.println(line)
    }
}
