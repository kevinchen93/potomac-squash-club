class User < ActiveRecord::Base

  has_and_belongs_to_many :court_reservations, dependent: :save

  validates :username, presence: true, uniqueness: true
  validates :password, presence: true
  validates :first_name, presence: true
  validates :last_name, presence: true

  def name
    self.first_name + self.last_name
  end
  
  def to_s
    self.first_name
  end

end
