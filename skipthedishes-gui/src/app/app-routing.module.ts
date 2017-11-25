import {NgModule} from "@angular/core";
import {PreloadAllModules, RouterModule, Routes} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {SearchComponent} from "./search/search.component";

const routes:Routes=[
  {path:'', component:HomeComponent},
  {path:'search', component:SearchComponent}
  ];


@NgModule({
  imports:[
    RouterModule.forRoot(routes/*,{preloadingStrategy:PreloadAllModules}*/)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule{

}
