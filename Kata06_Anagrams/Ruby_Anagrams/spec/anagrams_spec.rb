require 'spec_helper'

describe Anagrams do
  before(:all) do
    filename  = File.join(File.dirname(__FILE__), 'support', 'wordlist.txt')
    @wordlist = File.read(filename).split("\n")
    @anagrams = Anagrams.new(@wordlist).run
  end

  it 'should find anagrams' do
    expect(@anagrams).to eq({ "orst" => %w(rots sort)})
  end

  it 'should exclude words having no anagram partner' do
    expect(@anagrams.keys).to_not include("gaga")
  end
end
