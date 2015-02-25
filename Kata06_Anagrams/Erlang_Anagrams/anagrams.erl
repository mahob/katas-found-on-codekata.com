-module(anagrams).
-export([read_wordlist/1]).

read_wordlist(FileName) ->
  Dict = for_each_line_in_file(FileName, [read, {encoding, utf8}]),
  Anagrams = dict:to_list(Dict),
  [io:format("~n" ++ Key ++ ": " ++ string:join(Values, ", ")) || {Key, Values} <- Anagrams].

for_each_line_in_file(Name, Mode) ->
  {ok, Device} = file:open(Name, Mode),
  for_each_line(Device).

% Remove leading and trailing whitespaces
% (string:split doesn't remove readling/trailing line feeds)
strip(Text) ->
  re:replace(Text, "(^\\s+)|(\\s+$)", "", [global,{return,list}]).

for_each_line(Device) ->
  for_each_line(Device, dict:new(), 0).

for_each_line(Device, Dict, LineNumber) ->
  case io:get_line(Device, "") of
    eof  ->
      file:close(Device),
      Dict;
    Data ->
      Line = strip(Data),
      Anagram = lists:sort(Line),
      %           io:format("~n---~nLine [" ++ integer_to_list(LineNumber) ++"] " ++ Line ++ "~nAnagram: " ++ Anagram),
      NewDict = dict:update(Anagram, fun(Old) -> Old ++ [Line] end, [Line], Dict),
      for_each_line(Device, NewDict, LineNumber + 1)
  end.
