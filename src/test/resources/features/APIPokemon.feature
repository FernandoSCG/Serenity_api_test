@PokemonFeature
Feature: Obtener lista de pokemones
  Como un usuario de la API de pokemon
  Quiero obtener la lista de todas los pokemones
  Para poder verificar los detalles de los pokemones

  @CP1
  Scenario Outline: Obtener el pokemon por nombre exitosamente
    Given el actor establece el endpoint GET para obtener el pokemon
    When el actor consulta el pokemon llamado "<namePokemon>"
    Then el codigo de respuesta HTTP deberia ser 200 para la consulta
    Examples:
      | namePokemon |
      | pikachu     |
      | clefairy    |

  @CP1
  Scenario Outline: Obtener el pokemon por genero exitosamente
    Given el actor establece el endpoint GET para obtener los pokemones por genero
    When el actor consulta los pokemones de genero "<genderPokemon>"
    Then el codigo de respuesta HTTP deberia ser 200 para la consulta
    Examples:
      | genderPokemon |
      | female        |
      | male          |