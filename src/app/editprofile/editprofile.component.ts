import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DataService } from '../data.service';
import { reg } from '../reg.model';
import { FormBuilder } from '@angular/forms';
import { FormGroup, FormControl, FormArray } from '@angular/forms';
@Component({
  selector: 'app-editprofile',
  templateUrl: './editprofile.component.html',
  styleUrls: ['./editprofile.component.css']
})
export class EditprofileComponent implements OnInit {
  profileForm : FormGroup;
  reg1: reg = new reg();
  constructor(private fb: FormBuilder, private router: Router, private dataService: DataService) {

  }

  get skill() {
    return this.profileForm.get('skill') as FormArray;
  }
  get certification() {
    return this.profileForm.get('certification') as FormArray;
  }
  ngOnInit() { 
    this.profileForm = this.fb.group({
    highestEducation: (''),
    interest: (''),
    workExperience: (''),
    skill: this.fb.array([
      this.fb.control('')
    ]),
    certification: this.fb.array([
      this.fb.control('')
    ])
  });
  }
  addskill() {
    this.skill.push(this.fb.control(''));
  }
  addcerti() {
    this.certification.push(this.fb.control(''));
  }
  register() {

    console.log(this.profileForm.value);  

    this.dataService.register(this.profileForm.value).subscribe(
      res => {
        console.log(res);
        this.router.navigate(['/profile']);

      }, err => {
        console.log(err);

      }

    )
  }
}
