Rails.application.routes.draw do

  root 'static_pages#home'

  get 'login', to: 'static_pages#home'
  post 'login', to: 'sessions#login'

  get 'reserve', to: 'court_reservations#index'
  resources :users

end
