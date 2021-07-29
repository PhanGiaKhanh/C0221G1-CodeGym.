import {Component, OnInit} from '@angular/core';
import {EducationDegree} from '../../../model/employee/education-degree';
import {Division} from '../../../model/employee/division';
import {Position} from '../../../model/employee/position';
import {EmployeeService} from '../../../service/employee.service';
import {Employee} from '../../../model/employee/employee';
import {LoadCssService} from '../../../bootstrap/load-css.service';
import Swal from 'sweetalert2'
@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.scss']
})
export class EmployeeListComponent implements OnInit {
  positions!: Position[];
  degrees!: EducationDegree[];
  divisions!: Division[];
  employees!: Employee[];

  // sort
  key = '';
  reverse = false;
  // page
  page = 1;
  // search
  filter = '';
  nameSearch = '';
  emailSearch = '';

  // delete
  nameDelete = '';

  constructor(private employeeService: EmployeeService,
              private localCss: LoadCssService) {
    localCss.loadCss('https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css');
  }

  ngOnInit(): void {
    this.getEmployees();
    this.getPositionList();
    this.getEducationDegreeList();
    this.getDivisionList();
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

  sort(key) {
    this.key = key;
    this.reverse = !this.reverse;
  }

  search() {
    console.log(this.nameSearch);
    this.employeeService.search(this.nameSearch, this.emailSearch).subscribe(es => {
      this.employees = es;
      this.page = 1;
    });
  }

  removeDialog(e: Employee) {
    const swalWithBootstrapButtons = Swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    });

    swalWithBootstrapButtons.fire({
      title: 'Are you sure?',
      text: 'You won\'t be able to revert this!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, cancel!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
        swalWithBootstrapButtons.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        );
        this.employeeService.deleteEmployee(e.id).subscribe(() => {
          this.getEmployees();
        });
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === Swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelled',
          'Your imaginary file is safe :)',
          'error'
        );
      }
    });
  }
}
