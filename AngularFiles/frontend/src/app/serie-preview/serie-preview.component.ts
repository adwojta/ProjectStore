import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-serie-preview',
  templateUrl: './serie-preview.component.html',
  styleUrls: ['./serie-preview.component.scss']
})
export class SeriePreviewComponent implements OnInit {
  @Input() title: String;
  constructor() { }

  ngOnInit(): void {
  }

}
