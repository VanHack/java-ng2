import {Component, OnInit} from "@angular/core";
import {SearchService} from "../services/search/search.service";
import {FormControl} from "@angular/forms";
import "rxjs/add/operator/debounceTime";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  textControl: FormControl;


  constructor(private searchService:SearchService) { }

  ngOnInit() {

    this.textControl = new FormControl(this.searchService.currentText);

    this.textControl.valueChanges.debounceTime(800).subscribe(()=>{
      this.doSearch();
    })
  }


  doSearch(){
    this.searchService.doSearch(this.textControl.value);
  }

}
