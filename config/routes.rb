Rails.application.routes.draw do

  #root 'static_pages#home'

  get 'login', to: 'static_pages#home'
  post 'login', to: 'sessions#login'

  root 'court_reservations#index'
  get 'reserve', to: 'court_reservations#index'

  resources :users, only: [:show, :index]

end
