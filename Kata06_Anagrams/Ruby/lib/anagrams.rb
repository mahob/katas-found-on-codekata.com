class Anagrams
  def initialize(wordlist)
    @wordlist = wordlist
  end

  def run
    anagrams = @wordlist.inject({}) do |anagrams, w|
      k = w.split(//).sort.join('')
      anagrams[k] ||= []
      anagrams[k] << w
      anagrams
    end
    clear(anagrams)
  end

  def clear(anagrams)
    anagrams.each do |k, list|
      anagrams.delete(k) if list.size <= 1
    end
    anagrams
  end
end
