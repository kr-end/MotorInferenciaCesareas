import { selectMotivo } from "./main";

export function addOptionsToSelect(answers: string[]) {
  // Añadir opciones de respuesta al formulario
  answers.forEach((answer) => {
    const option = document.createElement("option") as HTMLOptionElement;
    option.text = answer;
    option.value = answer;
    selectMotivo.add(option);
  });
}
