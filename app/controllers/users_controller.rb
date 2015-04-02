class UsersController < ApplicationController

  before_action :set_user, only: [:index, :show, :create, :update, :destroy]
  
  respond_to :json, only: [:index, :show, :create, :update, :destroy]
  respond_to :html, only: :index

  def index
    respond_with users
  end

  def create
    @user = User.create(user_params)
  end

  def update
    user.update_attributes(user_params)
    respond_with user
  end

  def destroy
    respond_with user.destroy
  end


  private

  def user
    @user ||= User.find(params[:id])
  end

  def users
    @users ||= User.all
  end
  
  def user_params
    params.permit(:first_name, :last_name, :username, :password)
  end
end
