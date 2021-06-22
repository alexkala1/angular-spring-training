import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { RegisterComponent } from './register/register.component';
import { AuthGuard } from './auth/auth.guard'
import { NotFoundComponent } from './not-found/not-found.component';

const routes: Routes = [
	{ path: '', redirectTo: '/', pathMatch: 'full' },
  {
    path: 'login',
    component: LoginComponent,
		// canActivate: [!AuthGuard]
  },
  {
    path: '',
    component: HomeComponent,
		canActivate: [AuthGuard]
  },
  {
    path: 'register',
    component: RegisterComponent,
  },
  {
    path: 'profile',
    component: ProfileComponent,
		canActivate: [AuthGuard]
  },
	{
		path: '**',
		component: NotFoundComponent
	}
	
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
