Rails.application.routes.draw do

  get 'login', to: 'static_pages#home'
  post 'login', to: 'sessions#login'
  root 'static_pages#home'
  get 'reserve', to: 'court_reservations#index'
  resources :users

end
