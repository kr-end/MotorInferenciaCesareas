export interface QuestionRequestDto {
  pacientId: string;
  id: number;
  answer: string;
}

export interface QuestionResponseDto {
  id: number;
  question: string;
  answers: string[];
}

export interface CesareaResponseDto {
  tipo: string;
  motivo: string;
  tipoIncision: string;
  descripcion: string;
}
