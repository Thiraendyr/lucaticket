import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { MatTable } from '@angular/material/table';


@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.sass']
})
export class TableComponent implements OnInit {
  @Input() displayedColumns: string[] | any;
  @Input() dataSource : any;

  @ViewChild(MatTable) table: MatTable<any> | any;

  constructor() { }

  ngOnInit(): void {
    this.dataSource
  }


  addData() {
  }

  removeData() {
  }
}
