# Das Schicksal ist ein miser Verräter

"The fault in our stars" - or "Das Schicksal ist ein mieser Verräter" as it's called in German, is a book by John green 
which tells the story of Hazel, a teenager living in Indianapolis who has lung cancer.
She visits a support group where she meets Augustus Waters, who had bone cancer that is already healed though.
Not only do we witness one of the most moving love stories in literature, where Hazel and Augustus not only discover the 
good and bad of a love relationship, but also the ups and downs of living with cancer.

I am intending to create a [Geocache](geocaching.com) where players will become actors and take on the roles of Hazel and her friends.
The geocache will be interactive, meaning that players will have to take decisions which will have an impact on the course and outcome of the story.

This repository contains the screenplay for the geocache.
I wrote the first version of the screenplay in Word, but when I accidentally deleted the document and all of its backups,
I decided to write the whole thing from scratch in LaTeX.

I also attempted to use screenplay writing software, but they all didn't work for me as they all expect a linear storyline, since there's no interactivity in a movie.
So, I ended up creating my own LaTeX template for screenplays that also incorporates those interactive aspects.

## Features of the LaTeX template
- Formatted like a standard screenplay
- Automatic formatting of scene transitions, scene headings, scene descriptions and dialogs
- First occurrence of a character's name is automatically capitalized
- Possibility to create a character index
- **Incorporate interactive story elements:**
  Let the players decide how to proceed! 
  Allow the players to take certain decisions within your story that affect the course and outcome of the story. 
  Decisions can even be nested, meaning that one decision only appears if the player has picked a particular option in the previous decision. 
  This allows for some highly interactive story developments.
- Semantic syntax which would theoretically allow the screenplay to be read by a machine.
  
## Usage (How to apply the template to your own story)
### Recommended setup
- On Windows: MiKTeX, on any other OS: TeXLive
- IntelliJ Idea with the TeXify plugin
- Optional: JDK 8 to run the Kotlin helper script
- Optional: AutoHotkey

### Writing a screenplay
1. Download and install LaTeX. For Windows, I recommend MiKTeX.
2. If you wish to publish your screenplay on GitHub, fork this repository.
3. Clone or download this repository.
4. Optional: Open the folder `src` and make a copy of `main.tex`. This is pretty useful as it helps to look at my screenplay to see how the template works.
5. Open `main.tex` in a text editor. 
6. Go to the top of `main.tex` where it says `% Title`
7. Replace the `title`, `author`, `BasedOn` and `TitleSlug` fields. If you don't need `BasedOn` or `TitleSlug` just remove those lines entirely.
8. Remove everything between `\input{beginningOfDocument.tex}` and `\end{document}`.
9. Start writing your screenplay below `\input{beginningOfDocument.tex}` have a look at my [`main.tex`](src/main.tex) to see how to use the template.

### Using the list of characters
The template uses the `glossaries` package to manage character names.
To add your characters to the list, open `characters.tex` and replace the characters from my screenplay with your characters.

To add a character without a character description, just type `\character{Emma}`.
If you wish to add a character description, you can do that like so: `\character[A teenager who is 16 yearss old. She lives in Calcutta.]{Emma}`

When mentioning the character in your screenplay, use `\gls{Emma}`. 
This will capitalize the character's name when you first mention it and insert it with normal capitalization on all subsequent appearances.

Optional: I created a small Kotlin script that takes `characters.tex` and automatically creates an [AutoHotkey](https://www.autohotkey.com/) script for it that auto-replaces character names with `\gls{Character name}` as you type.
To run thhis Kotlin script, you need IntelliJ and a working Kotlin environment.
Then, open the Kotlin script in IntelliJ and run it by pressing the green play button at the beginning of the script.
When your list of characters changed, just run the Kotlin script again and it will update the AutoHotkey script.

## Exporting the screenplay as a PDF file
Simply compile `main.tex` with pdflatex as you would do with any other LaTeX document.
You may also upload your screenplay to [Overleaf.com](https://www.overleaf.com/) which renders your screenplay as you type.

## License
The LaTeX template is published under the Apache license v2. This includes:
- All files in this repository except for some portions of `main.tex`
- In `main.tex` everything except for the screenplay itself, i.e. everything but the part between `\input{beginningOfDocument.tex}` and `\end{document}`.

The screenplay itself (i.e. the part in `main.tex` between `\input{beginningOfDocument.tex}` and `\end{document}`) is published under the CC BY-SA 4.0 license.
