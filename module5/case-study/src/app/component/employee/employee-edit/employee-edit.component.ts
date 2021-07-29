import {Component, OnInit} from '@angular/core';
import {EmployeeService} from '../../../service/employee.service';
import {Position} from '../../../model/employee/position';
import {EducationDegree} from '../../../model/employee/education-degree';
import {Division} from '../../../model/employee/division';
import {Employee} from '../../../model/employee/employee';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, ParamMap} from '@angular/router';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.scss']
})
export class EmployeeEditComponent implements OnInit {

  constructor(private employeeService: EmployeeService,
              private fb: FormBuilder,
              private activatedRoute: ActivatedRoute) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.getEmployee(+paramMap.get('id'));
    });
  }

  editForm!: FormGroup;
  positions!: Position[];
  degrees!: EducationDegree[];
  divisions!: Division[];
  employees!: Employee[];
  employee!: Employee;
  validateEmployee = {
    name: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'minLength', msg1: 'Minlength 5 character'},
    ],
    division: [
      {type1: 'required', msg1: 'Not empty'},
    ],
    educationDegree: [
      {type1: 'required', msg1: 'Not empty'},
    ],
    position: [
      {type1: 'required', msg1: 'Not empty'},
    ],
    birthday: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'pattern', msg1: 'This is not date'},
    ],
    idCard: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'pattern', msg1: '9 or 12 numbers'},
    ],
    salary: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'pattern', msg1: 'Phải dương'},
    ],
    phone: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'pattern', msg1: 'Pattern (090|091|84+90|84+91)XXXXXX'},
    ],
    email: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'pattern', msg1: 'Pattern email'},
    ],
    address: [
      {type1: 'required', msg1: 'Not empty'},
      {type1: 'minLength', msg1: 'Minlength 5 character'},
    ]
  };

  ngOnInit(): void {
    this.getEmployees();
    this.getPositionList();
    this.getDivisionList();
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

  update() {
    const employee = this.editForm.value;
    this.employeeService.updateEmployee(employee).subscribe(() => {
      this.editForm.reset();
      alert('Tạo thành công');
    }, e => {
      alert('Thất bại');
    });
  }

  getEmployee(id: number) {
    return this.employeeService.findById(id).subscribe(e => {
      this.employee = e;
      this.editForm = this.fb.group({
        name: [e.name, [Validators.required, Validators.minLength(5)]],
        division: [e.division, [Validators.required]],
        educationDegree: [e.educationDegree, [Validators.required]],
        position: [e.position, [Validators.required]],
        birthday: [e.birthday, [Validators.required, Validators.pattern(/^([12][09][0-9]{2}-[01][0-9]-[0123][0-9])$/)]],
        idCard: [e.idCard, [Validators.required, Validators.pattern(/^([0-9]{9})|([0-9]{12})$/)]],
        salary: [e.salary, [Validators.required, Validators.pattern(/^[1-9][0-9]*$/)]],
        phone: [e.phone, [Validators.required, Validators.pattern(/^(090|091|(\(84\)\+90)|(\(84\)\+91))[0-9]{7}$/)]],
        email: [e.email, [Validators.required, Validators.email]],
        address: [e.address, [Validators.required, Validators.minLength(5)]]
      });
    });
  }
}
