# Gradle
## Podstawowe komendy

* `gradle init --type java-library` - stworzenie projektu Java
* `gradle tasks` - pokazuje informacje o dostępnych zadaniach
* Uruchamianie wybranych testów
  * `gradle test --tests org.gradle.SomeTest.someSpecificFeature`
  * `gradle test --tests *SomeTest.someSpecificFeature`
  * `gradle test --tests *SomeSpecificTest`
  * `gradle test --tests all.in.specific.package*`

## Dodatkowe informacje

* https://docs.gradle.org/current/userguide/build_init_plugin.html
* https://docs.gradle.org/current/userguide/application_plugin.html

# Git

## Podstawowe komendy
* `git init` - utworznie lokalnego repozytorium
* `git status` - informacje o stanie repozytorium
* `git add <nazwa_pliku>` - dodanie pliku do repozytorium 
* `git add -A` - dodatnie zmian (wszystkich nowych plików oraz zmian w istniejących plikach
* `git commit -m "informacje o zmianach"` - zatwierdzenie zmian i przypisanie im nazwy

* `git remote add origin <link-do-repozytorium>` - dodanie zdalnego repozytorium (np. git@github.com:jacekokrojek/jak-to-sie-robi-w-java.git)
* `git push` - przesłanie zmian do zdalnego repozytorium
* `git fetch` - aktualizacja informacji o zmianach w zdalnym repozytorium
* `git pull` - autoalizacja aktualnego brancha do wersji ze zdalnego repozytorium

* `git checkout <nazwa-branch>` - przejście na branch o podanej nazwie
* `git checkout -b <nazwa-branch>` - stworznie nowego brancha i przejście na nowy branch
* `git merge <nazwa-branch>` - połączenie aktualnego brancha z branchem o podanej nazwie

* `git reset --hard HEAD` - cofnięcie zmian i powrót do wersji z ostatniego commit'a

## Dodatkowe informacje
* https://nvie.com/posts/a-successful-git-branching-model/
* https://blog.osteele.com/2008/05/my-git-workflow/
* https://git-scm.com/book/pl/v2
* https://www.youtube.com/watch?v=ZDR433b0HJY