import {Component, OnInit} from '@angular/core';
import {Todo} from '../todo';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {TodoService} from '../todo.service';
import {Router} from '@angular/router';


let _id = 1;

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos: Todo[] = [];
  content = new FormControl();
  todo!: Todo;
  editForm!: FormGroup;
  hidden = true;

  constructor(private todoService: TodoService,
              private fb: FormBuilder,
  ) {
    this.editForm = this.fb.group({
      id: [],
      content: [''],
      complete: [''],
    });
  }

  ngOnInit() {
    this.getTodos();
  }

  getTodos() {
    this.todoService.getAll().subscribe(todos => {
      this.todos = todos;
    });
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
    this.todoService.updateTodo(this.todos[i]).subscribe(() => {
      alert('thành công');
    }, error => {
      alert('thất bại');
    });
  }

  change() {
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: _id++,
        content: value,
        complete: false
      };
      this.todos.push(todo);
      this.content.reset();
    }
  }

  getTodo(id) {
    this.todoService.findById(id).subscribe(todo => {
      this.todo = todo;
    });
  }
  getAll() {
    this.todoService.getAll().subscribe(todos => {
      this.todos = todos;
    });
  }
  edit(id: number) {
    this.todoService.findById(id).subscribe(todo => {
      this.todo = todo;
      this.editForm.patchValue(this.todo);
    });
  }

  editTodo() {
    console.log(this.editForm.value);
    this.todoService.updateTodo(this.editForm.value).subscribe(() => {
      document.getElementById('exitModal').click();
      this.getAll();
      this.editForm.reset();
      // alert('Thành công');
    }, error => {
      'Thất bại';
    });
  }
}
