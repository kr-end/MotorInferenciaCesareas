import { QuestionRequestDto, QuestionResponseDto } from './transactions/dtos/cesarea.dto';
import { createQuestion } from './transactions/question.transactions';
import { addOptionsToSelect } from './utils';
const slidePage = document.querySelector(".slide-page") as HTMLDivElement;
const nextBtnFirst: HTMLButtonElement = document.querySelector(
  ".firstNext"
) as HTMLButtonElement;
const nextBtnSec = document.querySelector(".next-1") as HTMLButtonElement;
const nextBtnThird = document.querySelector(".next-2") as HTMLButtonElement;
const submitBtn = document.querySelector(".submit") as HTMLButtonElement;
const progressText = document.querySelectorAll(".step p");
const progressCheck = document.querySelectorAll(".step .check");
const bullet = document.querySelectorAll(".step .bullet");

const idTxt = document.getElementById("idTxt") as HTMLInputElement;
const tipoCesarea = document.getElementById("tipoCesarea") as HTMLSelectElement;
export const selectMotivo = document.getElementById("selectMotivo") as HTMLSelectElement;

export const apiBaseUrl = "http://localhost:8080/api";

let current = 1;

const questionRequestDto: QuestionRequestDto = {
  pacientId: "",
  id: 0,
  answer: "",
};

nextBtnFirst.addEventListener("click", (event) => {
  // Validar que el campo de texto no esté vacío
  if (idTxt.value === "" || idTxt.value.length < 8) {
    // TODO mostrar mensaje de error en el formulario y cambiar a rojo el borde del campo de texto
    alert("El número de identificación no es válido");
    return;
  }

  // Obtener el valor del campo de texto y asignarlo al DTO
  questionRequestDto.pacientId = idTxt.value.trim();

  handleNextStep(event, 1, 25);
});

nextBtnSec.addEventListener("click", async (event) => {
  // Obtener el valor del select de tipo de cesárea y asignarlo al DTO
  questionRequestDto.answer = tipoCesarea.value;
  questionRequestDto.id = 1;

  // Enviar el DTO al backend, para obtener las opciones de respuesta 
  // Await es necesario para esperar la respuesta del backend, antes de continuar
  const response: QuestionResponseDto = await createQuestion(1, questionRequestDto);

  // Validar que el backend responda correctamente
  if (response === undefined) {
    alert("Error al enviar la respuesta");
    return;
  }

  // Añadir opciones de respuesta al formulario
  addOptionsToSelect(response.answers);
  
  handleNextStep(event, 1, 50);
});

// TODO: Implementar la lógica para el tercer paso del formulario
nextBtnThird.addEventListener("click", (event) => handleNextStep(event, 1, 75));

submitBtn.addEventListener("click", function () {
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  current += 1;
  setTimeout(function () {
    alert("Your Form Successfully Signed up");
    location.reload();
  }, 800);
});

function handleNextStep(event: Event, stepIncrement: number, slideIncrement: number) {
  event.preventDefault();
  // Avanzar al siguiente paso del formulario
  slidePage.style.marginLeft = `-${slideIncrement}%`;
  // Marcar el paso actual como completo
  bullet[current - 1].classList.add("active");
  progressCheck[current - 1].classList.add("active");
  progressText[current - 1].classList.add("active");
  // Incrementar el paso actual
  current += stepIncrement;
}

