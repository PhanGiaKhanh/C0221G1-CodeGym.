import {Division} from './division';
import {EducationDegree} from './education-degree';
import {Position} from './position';

export interface Employee {
  id: number;
  name: string;
  division: Division;
  educationDegree: EducationDegree;
  position: Position;
  birthday: Date;
  idCard: string;
  salary: string;
  phone: string;
  email: string;
  address: string;
}
