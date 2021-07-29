import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../../../service/employee.service';
import {Position} from '../../../model/employee/position';
import {EducationDegree} from '../../../model/employee/education-degree';
import {Division} from '../../../model/employee/division';
import {Employee} from '../../../model/employee/employee';
import {FormBuilder, FormGroup} from '@angular/forms';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.scss']
})
export class EmployeeEditComponent implements OnInit {
  editForm!: FormGroup;
  positions!: Position[];
  degrees!: EducationDegree[];
  divisions!: Division[];
  employees!: Employee[];
  employee!: Employee;

  constructor(private employeeService: EmployeeService,
              private fb: FormBuilder) {
  }

  ngOnInit(): void {
    this.getEmployees();
    this.getPositionList();
    this.getPositionList();
    this.getEducationDegreeList();
  }

  getEmployees() {
    this.employeeService.getAll().subscribe(employees => {
      this.employees = employees;
    });
  }

  getPositionList() {
    this.employeeService.getPositionList().subscribe(positions => {
      this.positions = positions;
    });
  }

  getDivisionList() {
    this.employeeService.getDivisionList().subscribe(divisions => {
      this.divisions = divisions;
    });
  }

  getEducationDegreeList() {
    this.employeeService.getEducationDegreeList().subscribe(degrees => {
      this.degrees = degrees;
    });
  }
}
